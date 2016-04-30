var Game = function(spec) {
    this.canvas = spec.canvas;
    this.rows = spec.rows;
    this.columns = spec.columns;
    this.style = spec.style || {};

    var board = new Board({
        canvasContext: this.canvas.getContext('2d'),
        width: this.canvas.width,
        height: this.canvas.height,
        rows: this.rows,
        columns: this.columns,
        style: this.style
    });
    for (var r = 0; r < this.rows; r++) {
        for (var c = 0; c < this.columns; c++) {
            board.addCell(r, c);
        }
    }

    var play = true;

    this.canvas.onclick = function(event) {
        if (play) {
            var boundingRect = canvas.getBoundingClientRect();
            board.makeBigExplosion(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
        } else {
            var boundingRect = canvas.getBoundingClientRect();
            board.switchCellState(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
            board.draw();
        }
    };
    this.canvas.onmousemove = function(event) {
        if (play) {
            var boundingRect = canvas.getBoundingClientRect();
            board.makeExplosion(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
        }
    };
    this.canvas.oncontextmenu = function(event) {
        event.preventDefault();
        play = !play;
        if (!play) {
            board.draw();
        }
    };

    var framesPerSecond = 25;
    var frameInterval = 1000 / framesPerSecond;
    var frameTimestamp = 0;

    var frame = function() {
        var now = Date.now();
        if (play && now - frameTimestamp >= frameInterval) {
            board.draw();
            frameTimestamp = now;
            board.iterate();
        }
        window.requestAnimationFrame(frame);
    }
    frame();
};

Game.prototype.start = function() {

};

Game.prototype.stop = function() {
};

Game.prototype.destroy = function() {
    this.canvas.onclick = null;
    this.canvas.onmousemove = null;
    this.canvas.oncontextmenu = null;
};
