var Cell = function(spec) {
    Cell.parent.constructor.call(this, spec);

    this.x = spec.x;
    this.y = spec.y;
    this.width = spec.width;
    this.height = spec.height;
    this.style = spec.style;
    this.state = Constants.STATE_DEAD;
};

extend(Cell, Drawable);

Cell.prototype.setState = function(state) {
    this.state = state;
};

Cell.prototype.switchState = function() {
    if (this.state === Constants.STATE_ALIVE) {
        this.state = Constants.STATE_DEAD;
    } else if (this.state === Constants.STATE_DEAD) {
        this.state = Constants.STATE_ALIVE;
    } else {
        throw 'Unexpected use of method';
    }
}

Cell.prototype.getState = function(state) {
    return this.state;
};

Cell.prototype.draw = function(parentCanvasContext) {
    if (this.state === Constants.STATE_ALIVE) {
        if (!this.style.aliveCellTransparent) {
            parentCanvasContext.beginPath();
            parentCanvasContext.fillStyle = this.style.aliveCellColor || '#000000';
            parentCanvasContext.rect(this.x, this.y, this.width, this.height);
            parentCanvasContext.fill();
        }
    } else if (this.state === Constants.STATE_DEAD) {
        if (!this.style.deadCellTransparent) {
            parentCanvasContext.beginPath();
            parentCanvasContext.fillStyle = this.style.deadCellColor || '#ffffff';
            parentCanvasContext.rect(this.x, this.y, this.width, this.height);
            parentCanvasContext.fill();
        }
    }
};
