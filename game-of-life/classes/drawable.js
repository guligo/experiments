var Drawable = function(spec) {
    this.canvasContext = spec && spec.canvasContext;
    this.children = [];
};

Drawable.prototype.addChild = function(child) {
    if (child instanceof Drawable) {
        this.children.push(child);
    }
};

Drawable.prototype.draw = function(parentCanvasContext) {
    this.children.forEach(function(child) {
        child.draw(this.canvasContext || parentCanvasContext);
    }.bind(this));
};
