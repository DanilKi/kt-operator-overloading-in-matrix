package mate.academy

class Matrix(private val rows: Int, private val cols: Int) {
    private val data = Array(rows) { IntArray(cols) }

    operator fun get(row: Int, col: Int): Int = data[row][col]
    operator fun set(row: Int, col: Int, value: Int) {
        data[row][col] = value
    }

    operator fun plus(other: Matrix): Matrix {
        // Validate that matrices have the same dimensions using require
        require(this.rows == other.rows && this.cols == other.cols) {
            "Matrices must have the same dimensions for addition"
        }
        val result = Matrix(this.rows, this.cols)
        for (i in 0 until this.rows) {
            for (j in 0 until this.cols) {
                result[i, j] = this[i, j] + other[i, j]
            }
        }
        return result
    }

    operator fun minus(other: Matrix): Matrix {
        // Validate that matrices have the same dimensions using require
        require(this.rows == other.rows && this.cols == other.cols) {
            "Matrices must have the same dimensions for subtraction"
        }
        val result = Matrix(this.rows, this.cols)
        for (i in 0 until this.rows) {
            for (j in 0 until this.cols) {
                result[i, j] = this[i, j] - other[i, j]
            }
        }
        return result
    }

    override fun toString(): String {
        return data.joinToString(separator = "\n") { row -> row.joinToString(" ") }
    }
}
