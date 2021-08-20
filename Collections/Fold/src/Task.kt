// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allProducts = customers.flatMap { it.getOrderedProducts() }.toSet()
    return customers.fold(allProducts) { common, it -> common.intersect(it.getOrderedProducts()) }
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }