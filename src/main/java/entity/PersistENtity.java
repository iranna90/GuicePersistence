package entity;

/**
 * Created by iranna.patil on 28-07-2016.
 */
public class PersistEntity {

    private long nodeId;

    private Node details;

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public Node getDetails() {
        return details;
    }

    public void setDetails(Node details) {
        this.details = details;
    }
}
