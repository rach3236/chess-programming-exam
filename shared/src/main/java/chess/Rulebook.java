package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Rulebook {
    public ChessPiece myPiece;

    public Rulebook() {
    }

    //CHECKS
    private boolean in_bounds(ChessPosition position) {
        return ((position.getRow() <= 8) && (position.getRow() >= 1) && (position.getColumn() <= 8) && (position.getColumn() >= 1));
    }

    private boolean check_square(ChessPosition new_position, ChessBoard board){
        if (!in_bounds(new_position)) return false;
        return (board.getPiece(new_position) == null);
    }

    private boolean enemy_piece(ChessPosition new_position, ChessBoard board) {
        ChessPiece piece = board.getPiece(new_position);
        return (myPiece.getTeamColor() != piece.getTeamColor());
    }

    private boolean if_king(){
        return (myPiece.getPieceType() == ChessPiece.PieceType.KING);
    }

    private void run_checks(ChessPosition position, Collection<ChessPosition> poss_positions, ChessBoard board) {
        if (!in_bounds(position)) return;
        if (!check_square(position, board) && !enemy_piece(position, board)) {return;}
        if (check_square(position, board)) {
            poss_positions.add(position);
        }
        if (!check_square(position, board) && enemy_piece(position, board)) {
            poss_positions.add(position);
        }
        return;
    }

    private boolean first_move_check(ChessPosition position) {
        if (position.getRow() == 2 && myPiece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            return true;
        } else if (position.getRow() == 7 && myPiece.getTeamColor() == ChessGame.TeamColor.BLACK) {
            return true;
        }
        return false;
    }


    //MOVES
    private void up_left(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow()+1, myPos.getColumn()-1);

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                up_left(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void up_right(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow()+1, myPos.getColumn()+1);

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                up_right(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void down_right(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow()-1, myPos.getColumn()+1);

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                down_right(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void down_left(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow()-1, myPos.getColumn()-1);

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                down_left(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }



    private void straight_left(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow(), myPos.getColumn()-1);

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                straight_left(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void straight_up(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow()+1, myPos.getColumn());

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                straight_up(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void straight_right(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow(), myPos.getColumn()+1);

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                straight_right(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void straight_down(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board) {
        ChessPosition new_pos = new ChessPosition(myPos.getRow()-1, myPos.getColumn());

        if (in_bounds(new_pos)) {
            if (check_square(new_pos, board)) {
                poss_positions.add(new_pos);
                if (if_king()) return;
                straight_down(new_pos, poss_positions, board);
            }
            if (!check_square(new_pos, board) && enemy_piece(new_pos, board)) {
                poss_positions.add(new_pos);
                return;
            } else {
                return;
            }
        }

    }

    private void knight_moves(ChessPosition myPos, Collection<ChessPosition> poss_positions, ChessBoard board){
        Collection<ChessPosition> poss_knight_positions = new ArrayList<>();

        poss_knight_positions.add(new ChessPosition(myPos.getRow()+2, myPos.getColumn()-1));
        poss_knight_positions.add(new ChessPosition(myPos.getRow()+2, myPos.getColumn()+1));
        poss_knight_positions.add(new ChessPosition(myPos.getRow()-2, myPos.getColumn()-1));
        poss_knight_positions.add(new ChessPosition(myPos.getRow()-2, myPos.getColumn()+1));

        poss_knight_positions.add(new ChessPosition(myPos.getRow()+1, myPos.getColumn()-2));
        poss_knight_positions.add(new ChessPosition(myPos.getRow()+1, myPos.getColumn()+2));
        poss_knight_positions.add(new ChessPosition(myPos.getRow()-1, myPos.getColumn()-2));
        poss_knight_positions.add(new ChessPosition(myPos.getRow()-1, myPos.getColumn()+2));

        for (ChessPosition knight_pos : poss_knight_positions) {
            run_checks(knight_pos, poss_positions, board);
        }
    }


    //PIECE RULES
    public Collection<ChessMove> bishop_rules(ChessPosition myPosition, Collection<ChessMove> poss_moves, ChessBoard board){
        Collection<ChessPosition> poss_positions = new ArrayList<>();

        myPiece = board.getPiece(myPosition);

        up_left(myPosition, poss_positions, board);
        up_right(myPosition, poss_positions, board);
        down_right(myPosition, poss_positions, board);
        down_left(myPosition, poss_positions, board);


        for (ChessPosition pos : poss_positions) {
            poss_moves.add(new ChessMove(myPosition, pos, null));
        }

        return poss_moves;
    }

    // rook_rules
    public Collection<ChessMove> rook_rules(ChessPosition myPosition, Collection<ChessMove> poss_moves, ChessBoard board) {
        Collection<ChessPosition> poss_positions = new ArrayList<>();

        myPiece = board.getPiece(myPosition);

        straight_left(myPosition, poss_positions, board);
        straight_up(myPosition, poss_positions, board);
        straight_right(myPosition, poss_positions, board);
        straight_down(myPosition, poss_positions, board);


        for (ChessPosition pos : poss_positions) {
            poss_moves.add(new ChessMove(myPosition, pos, null));
        }

        return poss_moves;
    }

    // queen_rules
    public Collection<ChessMove> queen_rules(ChessPosition myPosition, Collection<ChessMove> poss_moves, ChessBoard board) {
        Collection<ChessPosition> poss_positions = new ArrayList<>();

        myPiece = board.getPiece(myPosition);

        up_left(myPosition, poss_positions, board);
        up_right(myPosition, poss_positions, board);
        down_right(myPosition, poss_positions, board);
        down_left(myPosition, poss_positions, board);

        straight_left(myPosition, poss_positions, board);
        straight_up(myPosition, poss_positions, board);
        straight_right(myPosition, poss_positions, board);
        straight_down(myPosition, poss_positions, board);


        for (ChessPosition pos : poss_positions) {
            poss_moves.add(new ChessMove(myPosition, pos, null));
        }

        return poss_moves;
    }

    //king_rules
    public Collection<ChessMove> king_rules(ChessPosition myPosition, Collection<ChessMove> poss_moves, ChessBoard board) {
        Collection<ChessPosition> poss_positions = new ArrayList<>();

        myPiece = board.getPiece(myPosition);

        up_left(myPosition, poss_positions, board);
        up_right(myPosition, poss_positions, board);
        down_right(myPosition, poss_positions, board);
        down_left(myPosition, poss_positions, board);

        straight_left(myPosition, poss_positions, board);
        straight_up(myPosition, poss_positions, board);
        straight_right(myPosition, poss_positions, board);
        straight_down(myPosition, poss_positions, board);


        for (ChessPosition pos : poss_positions) {
            poss_moves.add(new ChessMove(myPosition, pos, null));
        }

        return poss_moves;
    }

    //knight_rules
    public Collection<ChessMove> knight_rules(ChessPosition myPosition, Collection<ChessMove> poss_moves, ChessBoard board) {
        Collection<ChessPosition> poss_positions = new ArrayList<>();
        myPiece = board.getPiece(myPosition);

        knight_moves(myPosition, poss_positions, board);

        for (ChessPosition pos : poss_positions) {
            poss_moves.add(new ChessMove(myPosition, pos, null));
        }
        return poss_moves;
    }

    //pawn rules
    public Collection<ChessMove> pawn_rules(ChessPosition myPosition, Collection<ChessMove> poss_moves, ChessBoard board) {
        Collection<ChessPosition> poss_positions = new ArrayList<>();
        myPiece = board.getPiece(myPosition);

        // WHITE PAWNS
        if (myPiece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            ChessPosition up_move = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn());

            if (in_bounds(up_move)) {
                if (check_square(up_move, board)) {
                    poss_positions.add(up_move);
                    if (check_square(new ChessPosition(up_move.getRow()+1, up_move.getColumn()), board) && first_move_check(myPosition)) {
                        poss_positions.add(new ChessPosition(up_move.getRow()+1, up_move.getColumn()));
                    }

                }

                ChessPosition enemy_pos1 = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
                ChessPosition enemy_pos2 = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);

                if (in_bounds(enemy_pos1)) {
                    if (!check_square(enemy_pos1, board) && enemy_piece(enemy_pos1, board)) {
                        poss_positions.add(enemy_pos1);
                    }
                }
                if (in_bounds(enemy_pos2)) {
                    if (!check_square(enemy_pos2, board) && enemy_piece(enemy_pos2, board)) {
                        poss_positions.add(enemy_pos2);
                    }
                }
            }
        }


        // BLACK PAWNS
        if (myPiece.getTeamColor() == ChessGame.TeamColor.BLACK) {
            ChessPosition down_move = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn());

            if (in_bounds(down_move)) {
                if (check_square(down_move, board)) {
                    poss_positions.add(down_move);
                    if (check_square(new ChessPosition(down_move.getRow() - 1, down_move.getColumn()), board) && first_move_check(myPosition)) {
                        poss_positions.add(new ChessPosition(down_move.getRow() - 1, down_move.getColumn()));
                    }
                }

                ChessPosition enemy_pos1 = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1);
                ChessPosition enemy_pos2 = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1);

                if (in_bounds(enemy_pos1)) {
                    if (!check_square(enemy_pos1, board) && enemy_piece(enemy_pos1, board)) {
                        poss_positions.add(enemy_pos1);
                    }
                }
                if (in_bounds(enemy_pos2)) {
                    if (!check_square(enemy_pos2, board) && enemy_piece(enemy_pos2, board)) {
                        poss_positions.add(enemy_pos2);
                    }
                }
            }
        }

        for (ChessPosition pos : poss_positions) {
            if (pos.getRow() == 8 && myPiece.getTeamColor() == ChessGame.TeamColor.WHITE) {
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.QUEEN));
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.BISHOP));
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.ROOK));
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.KNIGHT));
            } else if (pos.getRow() == 1 && myPiece.getTeamColor() == ChessGame.TeamColor.BLACK) {
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.QUEEN));
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.BISHOP));
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.ROOK));
                poss_moves.add(new ChessMove(myPosition, pos, ChessPiece.PieceType.KNIGHT));
            } else {
                poss_moves.add(new ChessMove(myPosition, pos, null));
            }
        }
        return poss_moves;
    }






}
