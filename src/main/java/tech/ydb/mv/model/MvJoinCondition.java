package tech.ydb.mv.model;

/**
 *
 * @author zinal
 */
public class MvJoinCondition implements MvSqlPosHolder {

    private MvLiteral firstLiteral;
    private MvJoinSource firstRef;
    private String firstAlias;
    private String firstColumn;
    private MvLiteral secondLiteral;
    private MvJoinSource secondRef;
    private String secondAlias;
    private String secondColumn;
    private final MvSqlPos sqlPos;

    public MvJoinCondition(MvSqlPos sqlPos) {
        this.sqlPos = sqlPos;
    }

    public MvJoinCondition() {
        this(MvSqlPos.EMPTY);
    }

    public MvLiteral getFirstLiteral() {
        return firstLiteral;
    }

    public void setFirstLiteral(MvLiteral firstLiteral) {
        this.firstLiteral = firstLiteral;
    }

    public MvJoinSource getFirstRef() {
        return firstRef;
    }

    public void setFirstRef(MvJoinSource firstRef) {
        this.firstRef = firstRef;
    }

    public String getFirstAlias() {
        return firstAlias;
    }

    public void setFirstAlias(String firstAlias) {
        this.firstAlias = firstAlias;
    }

    public String getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(String firstColumn) {
        this.firstColumn = firstColumn;
    }

    public MvLiteral getSecondLiteral() {
        return secondLiteral;
    }

    public void setSecondLiteral(MvLiteral secondLiteral) {
        this.secondLiteral = secondLiteral;
    }

    public MvJoinSource getSecondRef() {
        return secondRef;
    }

    public void setSecondRef(MvJoinSource secondRef) {
        this.secondRef = secondRef;
    }

    public String getSecondAlias() {
        return secondAlias;
    }

    public void setSecondAlias(String secondAlias) {
        this.secondAlias = secondAlias;
    }

    public String getSecondColumn() {
        return secondColumn;
    }

    public void setSecondColumn(String secondColumn) {
        this.secondColumn = secondColumn;
    }

    @Override
    public MvSqlPos getSqlPos() {
        return sqlPos;
    }

}
