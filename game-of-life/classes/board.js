var Board = function(spec) {
    Board.parent.constructor.call(this, spec);

    this.width = spec.width;
    this.height = spec.height;
    this.rows = spec.rows;
    this.columns = spec.columns;
    this.cellWidth = Math.round(this.width / this.columns);
    this.cellHeight = Math.round(this.height / this.rows);
};

extend(Board, Drawable);

Board.prototype.addCell = function(row, column) {
    this.addChild(new Cell({
        x: column * this.cellWidth,
        y: row * this.cellHeight,
        width: this.cellWidth,
        height: this.cellHeight,
    }));
};

Board.prototype.setCellState = function(row, column, state) {
    setCellState.call(this, row, column, state);
};

Board.prototype.makeChange = function(x, y) {
    var r = getRow.call(this, y);
    var c = getColumn.call(this, x);

    var cell = this.children[r * this.columns + c];
    if (cell.getState() === Constants.STATE_ALIVE) {
        cell.setState(Constants.STATE_DEAD);
    } else if (cell.getState() === Constants.STATE_DEAD) {
        cell.setState(Constants.STATE_ALIVE);
    }
};

Board.prototype.makeExplosion = function(x, y) {
    var r = getRow.call(this, y);
    var c = getColumn.call(this, x);

    var cells = [];
    cells.push(this.children[r * this.columns + c]);
    cells.push(this.children[(r + 1) * this.columns + c]);
    cells.push(this.children[(r - 1) * this.columns + c]);
    cells.push(this.children[r * this.columns + (c - 1)]);
    cells.push(this.children[r * this.columns + (c + 1)]);

    cells.forEach(function(cell) {
        if (cell) {
            cell.setState(Constants.STATE_ALIVE);
        }
    });
};

Board.prototype.draw = function(dryRun) {
    this.canvasContext.clearRect(0, 0, this.width, this.height);

    if (!dryRun) {
        Board.parent.draw.call(this);
    }

    this.canvasContext.beginPath();
    for (var c = 0; c <= this.columns; c++) {
        this.canvasContext.moveTo(c * this.cellWidth + (c < this.columns ? 0.5 : 0), 0);
        this.canvasContext.lineTo(c * this.cellWidth + (c < this.columns ? 0.5 : 0), this.height);
    }
    for (var r = 0; r <= this.rows; r++) {
        this.canvasContext.moveTo(0, r * this.cellHeight + (r < this.rows ? 0.5 : 0));
        this.canvasContext.lineTo(this.width, r * this.cellHeight + (r < this.rows ? 0.5 : 0));
    }
    this.canvasContext.lineWidth = 1;
    this.canvasContext.stroke();
};

Board.prototype.iterate = function() {
    updateCellStates.call(this, getNewCellStates.call(this));
};

var setCellState = function(row, column, state) {
    this.children[row * this.columns + column].setState(state);
};

var updateCellStates = function(newCellStates) {
    for (var r = 0; r < this.rows; r++) {
        for (var c = 0; c < this.columns; c++) {
            setCellState.call(this, r, c, newCellStates[r * this.columns + c]);
        }
    }
};

var getNewCellStates = function() {
    var newStates = [];
    for (var r = 0; r < this.rows; r++) {
        for (var c = 0; c < this.columns; c++) {
            var cellIndex = r * this.columns + c;
            var cell = this.children[cellIndex];

            var neighbors = [];
            neighbors.push(this.children[(r - 1) * this.columns + c]);
            neighbors.push(this.children[r * this.columns + (c + 1)]);
            neighbors.push(this.children[(r + 1) * this.columns + c]);
            neighbors.push(this.children[r * this.columns + (c - 1)]);
            neighbors.push(this.children[(r - 1) * this.columns + (c - 1)]);
            neighbors.push(this.children[(r - 1) * this.columns + (c + 1)]);
            neighbors.push(this.children[(r + 1) * this.columns + (c - 1)]);
            neighbors.push(this.children[(r + 1) * this.columns + (c + 1)]);

            var neighborsAlive = 0;
            neighbors.forEach(function(neighbor) {
                if (neighbor && neighbor.getState() === Constants.STATE_ALIVE) {
                    neighborsAlive++;
                }
            });

            newStates[cellIndex] = Constants.STATE_DEAD;
            if (neighborsAlive === 2 && cell.getState() === Constants.STATE_ALIVE) {
                newStates[cellIndex] = Constants.STATE_ALIVE;
            } else if (neighborsAlive === 3) {
                newStates[cellIndex] = Constants.STATE_ALIVE;
            }
        }
    }
    return newStates;
};

function getRow(y) {
    for (var r = 0; r < this.rows; r++) {
        if (r * this.cellHeight > y) {
            break;
        }
    }
    return r - 1;
}

function getColumn(x) {
    for (var c = 0; c < this.columns; c++) {
        if (c * this.cellWidth >= x) {
            break;
        }
    }
    return c - 1;
}
