package main.core.parsers.domroutines;

import main.core.enums.OrderStatus;
import main.core.entities.Order;
import org.w3c.dom.Node;

import java.time.LocalDateTime;

public class OrderDomRoutine extends DomBaseRoutine {
    @Override
    public Order getFromNode(Node node) {
        var order = new Order();
        order.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
        var childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            var nodeName = childNodes.item(i).getNodeName();
            var content = childNodes.item(i).getTextContent();
            switch (nodeName) {
                case "userId":
                    order.setUserId(Integer.parseInt(content));
                    break;
                case "carId":
                    order.setCarId(Integer.parseInt(content));
                    break;
                case "startDate":
                    order.setStartDate(LocalDateTime.parse(content));
                    break;
                case "endDate":
                    order.setEndDate(LocalDateTime.parse(content));
                    break;
                case "status":
                    order.setStatus(OrderStatus.valueOf(content));
                    break;
            }
        }
        return order;
    }

    public OrderDomRoutine(String className) {
        super(className);
    }
}
