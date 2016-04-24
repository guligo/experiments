var Game = function(spec) {
    this.canvas = spec.canvas;
    this.height = spec.height;
    this.width = spec.width;

    var cellWidth = this.canvas.width / this.width;
    var cellHeight = this.canvas.height / this.height;

    var board = new Board({
        canvasContext: spec.canvas.getContext('2d'),
        width: spec.width,
        height: spec.height,
        cellWidth: cellWidth,
        cellHeight: cellHeight
    });
    for (var h = 0; h < this.height; h++) {
        for (var w = 0; w < this.width; w++) {
            board.addChild(new Cell({
                x: w * cellWidth,
                y: h * cellHeight,
                width: cellWidth,
                height: cellHeight,
            }));
        }
    }
    board.setCellState(0, 0, Constants.STATE_ALIVE);
    board.setCellState(5, 10, Constants.STATE_ALIVE);
    board.draw();
};
