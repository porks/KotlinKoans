// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
//    return customers.filter { it.orders.count { order -> !order.isDelivered } > it.orders.count(Order::isDelivered) }.toSet()
    return customers.filter {
        val (delivery, undelivery) = it.orders.partition(Order::isDelivered)
        undelivery.size > delivery.size
    }.toSet()


}
