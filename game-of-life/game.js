var Game = function(spec) {
    this.canvas = spec.canvas;
    this.rows = spec.rows;
    this.columns = spec.columns;
    this.fps = spec.fps || 25;
    this.style = spec.style || {};
    this.play = true;

    this.board = new Board({
        canvasContext: this.canvas.getContext('2d'),
        width: this.canvas.width,
        height: this.canvas.height,
        rows: this.rows,
        columns: this.columns,
        style: this.style
    });
    for (var r = 0; r < this.rows; r++) {
        for (var c = 0; c < this.columns; c++) {
            this.board.addCell(r, c);
        }
    }

    initEventListeners.call(this);
};

Game.prototype.start = function() {
    var frameInterval = 1000 / this.fps;
    var frameTimestamp = 0;

    var frame = function() {
        var now = Date.now();
        if (this.play && now - frameTimestamp >= frameInterval) {
            this.board.draw();
            frameTimestamp = now;
            this.board.iterate();
        }
        this.requestId = window.requestAnimationFrame(frame);
    }.bind(this)
    frame();
};

Game.prototype.stop = function() {
    if (this.requestId) {
        window.cancelAnimationFrame(this.requestId);
    }
};

Game.prototype.destroy = function() {
    removeEventListeners.call(this);
};

function initEventListeners() {
    this.canvasClickEventListener = function(event) {
        if (this.play) {
            var boundingRect = canvas.getBoundingClientRect();
            this.board.makeBigExplosion(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
        } else {
            var boundingRect = canvas.getBoundingClientRect();
            this.board.switchCellState(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
            this.board.draw();
        }
    }.bind(this);
    this.canvas.addEventListener('click', this.canvasClickEventListener);

    this.canvasMouseMoveEventListener = function(event) {
        if (this.play) {
            var boundingRect = canvas.getBoundingClientRect();
            this.board.makeExplosion(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
        }
    }.bind(this);
    this.canvas.addEventListener('mousemove', this.canvasMouseMoveEventListener);

    this.canvasContextMenuListener = function(event) {
        event.preventDefault();
        this.play = !this.play;
        if (!this.play) {
            this.board.draw();
        }
    }.bind(this);
    this.canvas.addEventListener('contextmenu', this.canvasContextMenuListener);
};

function removeEventListeners() {
    this.canvas.removeEventListener('click', this.canvasClickEventListener);
    this.canvas.removeEventListener('mousemove', this.canvasMouseMoveEventListener);
    this.canvas.removeEventListener('contextmenu', this.canvasContextMenuListener);
};
