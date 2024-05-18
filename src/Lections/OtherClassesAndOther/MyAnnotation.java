package Lections.OtherClassesAndOther;

//@Target(ElementType.FIELD) Мы ограничили ее использование
//@Inherited позволяет при использовании аннотации в родителььском классе наследовать эту аннотацию
//@Retention(RetentionPolicy.CLASS) устанавливает, когда аннотация будет срабоатывать
public @interface MyAnnotation {
    //Чтобы создать новую аннотацию, надо поставить собаку перед словом интерфейс
    int number() default 5;
    //можно прописывать значения по умолчанию, а потом переписать при использовании
    String name();
    float digit();
// создавать аннотации почти не требуется-ебли много
}
