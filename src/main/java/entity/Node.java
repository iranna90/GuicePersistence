package entity;

import java.util.BitSet;
import java.util.Set;

/**
 * Created by iranna.patil on 28-07-2016.
 */
public class Node {

    private Set<Long> incoming;

    private Set<Long> outGoing;

    private BitSet bitSet;

    public Set<Long> getIncoming() {
        return incoming;
    }

    public void setIncoming(Set<Long> incoming) {
        this.incoming = incoming;
    }

    public Set<Long> getOutGoing() {
        return outGoing;
    }

    public void setOutGoing(Set<Long> outGoing) {
        this.outGoing = outGoing;
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    public void setBitSet(BitSet bitSet) {
        this.bitSet = bitSet;
    }
}
