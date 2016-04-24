var Board = function(spec) {
    Board.parent.constructor.call(this, spec);

    this.width = spec.width;
    this.height = spec.height;
    this.cellWidth = spec.cellWidth;
    this.cellHeight = spec.cellHeight;
};

extend(Board, Drawable);

Board.prototype.setCellState = function(x, y, state) {
    this.children[y * this.width + x].setState(state);
};

Board.prototype.draw = function() {
    Board.parent.draw.call(this);

    this.canvasContext.beginPath();
    for (var w = 0; w < this.width; w++) {
        this.canvasContext.moveTo(w * this.cellWidth, 0);
        this.canvasContext.lineTo(w * this.cellWidth, this.height * this.cellHeight);
    }
    for (var h = 0; h < this.height; h ++) {
        this.canvasContext.moveTo(0, h * this.cellHeight);
        this.canvasContext.lineTo(this.width  * this.cellWidth, h * this.cellHeight);
    }
    this.canvasContext.stroke();
};
