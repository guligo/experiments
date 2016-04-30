var Cell = function(spec) {
    Cell.parent.constructor.call(this, spec);

    this.x = spec.x;
    this.y = spec.y;
    this.width = spec.width;
    this.height = spec.height;
    this.state = Constants.STATE_DEAD;
};

extend(Cell, Drawable);

Cell.prototype.setState = function(state) {
    this.state = state;
};

Cell.prototype.getState = function(state) {
    return this.state;
};

Cell.prototype.draw = function(parentCanvasContext) {
    if (this.state === Constants.STATE_ALIVE) {
        parentCanvasContext.beginPath();
        parentCanvasContext.fillStyle = 'block';
        parentCanvasContext.rect(this.x, this.y, this.width, this.height);
        parentCanvasContext.fill();
    }
};
