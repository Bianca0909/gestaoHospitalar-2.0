package enums;

public enum StatusCadastroEnum {
    ATIVO("A"),
    INATIVO("I");

    private final String status;

    StatusCadastroEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
