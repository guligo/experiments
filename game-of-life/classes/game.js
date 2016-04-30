var Game = function(spec) {
    this.canvas = spec.canvas;
    this.rows = spec.rows;
    this.columns = spec.columns;

    var board = new Board({
        canvasContext: this.canvas.getContext('2d'),
        width: this.canvas.width,
        height: this.canvas.height,
        rows: spec.rows,
        columns: spec.columns
    });
    for (var r = 0; r < this.rows; r++) {
        for (var c = 0; c < this.columns; c++) {
            board.addCell(r, c);
        }
    }

    var play = true;
    var boundingRect = canvas.getBoundingClientRect();

    this.canvas.onclick = function(event) {
        if (!play) {
            board.makeChange(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
            board.draw();
        }
    };
    this.canvas.onmousemove = function(event) {
        if (play) {
            board.makeExplosion(event.clientX - boundingRect.left, event.clientY - boundingRect.top);
        }
    };
    canvas.oncontextmenu = function (e) {
        e.preventDefault();
        play = !play;
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
