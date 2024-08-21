import { Game } from "../../types/custom-types";
import "./styles.css";

type Props = {
  game: Game;
};

function GameCard({ game }: Props) {
  return (
    <div className="card" id="game-card" key={game.id}>
      <img className="card-img-top" src={game.imageUrl} alt="" />
      <div className="card-body">
        <h5 className="card-title">{game.name}</h5>
        <p className="card-text">{game.consoleName}</p>
        <p className="card-text">{game.releaseYear}</p>
      </div>
    </div>
  );
}

export default GameCard;
