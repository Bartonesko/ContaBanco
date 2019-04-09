package contaDefinitivo;

public class Move {
	private String description;
	private double value;
	private MoveType moveType;

	public Move(String description, double value, MoveType moveType) {
		super();
		this.description = description;
		this.value = value;
		this.moveType = moveType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public MoveType getMoveType() {
		return moveType;
	}

	public void setMoveType(MoveType moveType) {
		this.moveType = moveType;
	}

	@Override
	public String toString() {
		return description + value + "              tipo de movimetação: " + moveType + ".";
	}

}
