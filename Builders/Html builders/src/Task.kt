fun renderProductTable(): String {
    return html {
        table {
            tr (color = getTitleColor())  {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            products.forEachIndexed { row, product -> tr {
                td (color = getCellColor(0, row)) {
                    text(product.description)
                }
                td (color = getCellColor(1, row)) {
                    text(product.price)
                }
                td (color = getCellColor(2, row)) {
                    text(product.popularity)
                }
            } }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
