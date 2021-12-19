package com.oswizar.io.designpattern.chain;

public abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);


    // 使用建造者优化
    static class Builder {

        private Handler head;
        private Handler tail;

        public Builder addHandler(Handler handler) {

            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }

            // 关键代码，形成链
            this.tail.setNext(handler);
            this.tail = handler;

            return this;
        }


        public Handler build() {
            return this.head;
        }
    }
}
