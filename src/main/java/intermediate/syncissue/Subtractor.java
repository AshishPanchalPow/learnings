package intermediate.syncissue;

import java.util.concurrent.Callable;

public class Subtractor implements Callable {
    Value val;
    Subtractor(Value val){
        this.val=val;
    }
    @Override
    public Void call() throws Exception {
        for(int i=0;i<100;i++){
            this.val.val -=1;
        }
        return null;
    }
}
