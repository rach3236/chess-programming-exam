package chess;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private final ChessGame.TeamColor pieceColor;
    private final ChessPiece.PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor(){
        return pieceColor;

    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public static Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possible_moves = new ArrayList<>();

        Rulebook rules = new Rulebook();

        ChessPiece piece = board.getPiece(myPosition);

        if (piece.getPieceType() == PieceType.BISHOP) {
            rules.bishop_rules(myPosition, possible_moves, board);
        } else if (piece.getPieceType() == PieceType.ROOK) {
            rules.rook_rules(myPosition, possible_moves, board);
        } else if (piece.getPieceType() == PieceType.QUEEN) {
            rules.queen_rules(myPosition, possible_moves, board);
        } else if (piece.getPieceType() == PieceType.KING) {
            rules.king_rules(myPosition, possible_moves, board);
        } else if (piece.getPieceType() == PieceType.KNIGHT) {
            rules.knight_rules(myPosition, possible_moves, board);
        } else if (piece.getPieceType() == PieceType.PAWN) {
            rules.pawn_rules(myPosition, possible_moves, board);
        }

        return possible_moves;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ChessPiece that)) {
            return false;
        }
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }
}
