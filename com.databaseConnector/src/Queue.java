public class Queue<ContentType> {

    /* --------- Anfang der privaten inneren Klasse -------------- */

    private class QueueNode {

        private ContentType content = null;
        private QueueNode nextNode = null;

        /**
         * Ein neues Objekt vom Typ QueueNode<ContentType> wird erschaffen.
         * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
         *
         * @param pContent das Inhaltselement des Knotens vom Typ ContentType
         */
        public QueueNode(ContentType pContent) {
            content = pContent;
            nextNode = null;
        }

        /**
         * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
         * gesetzt.
         *
         * @param pNext der Nachfolger des Knotens
         */
        public void setNext(QueueNode pNext) {
            nextNode = pNext;
        }

        /**
         * Liefert das naechste Element des aktuellen Knotens.
         *
         * @return das Objekt vom Typ QueueNode, auf das der aktuelle Verweis zeigt
         */
        public QueueNode getNext() {
            return nextNode;
        }

        /**
         * Liefert das Inhaltsobjekt des Knotens vom Typ ContentType.
         *
         * @return das Inhaltsobjekt des Knotens
         */
        public ContentType getContent() {
            return content;
        }

    }

    /* ----------- Ende der privaten inneren Klasse -------------- */

    private QueueNode head;
    private QueueNode tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(ContentType pContent) {
        if (pContent != null) {
            QueueNode newNode = new QueueNode(pContent);
            if (this.isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }
    }

    public void dequeue() {
        if (!this.isEmpty()) {
            head = head.getNext();
            if (this.isEmpty()) {
                head = null;
                tail = null;
            }
        }
    }

    public ContentType front() {
        if (this.isEmpty()) {
            return null;
        } else {
            return head.getContent();
        }
    }

}














