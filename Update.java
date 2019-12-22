package class_08_aic;
import java.util.List;
public class Update extends Command {
    public static final int num = 4;
    private static Command instance = new Update();

    private Update() {
        super(num, "更新数据");
    }
    public static Command getInstance() {
        return instance;
    }
    public String run(ParaForCommand p) {
        return null;
    }
}