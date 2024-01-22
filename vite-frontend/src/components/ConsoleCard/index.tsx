import { ConsoleType } from "../../types/custom-types";

type Props = {
  consoleType: ConsoleType;
}

export default function ConsoleCard({ consoleType }: Props) {
  return (
    <div className="card" id="game-card" key={consoleType.id}>
      <img className="card-img-top" src={consoleType.imgUrl} alt="" />
      <div className="card-body">
        <h5 className="card-title">{consoleType.name}</h5>
        <p className="card-text">{consoleType.releaseYear}</p>
      </div>
    </div>
  );
}
