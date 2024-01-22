import { ConsoleType } from "../../types/custom-types";
import './styles.css';

type Props = {
  consoleType: ConsoleType;
}

export default function ConsoleCard({ consoleType }: Props) {
  return (
    <div className="card" id="console-card" key={consoleType.id}>
      <div className="card-body">
        <h5 className="card-title">{consoleType.name}</h5>
        <p className="card-text">{consoleType.releaseYear}</p>
      </div>
      <img className="card-img-top" src={consoleType.imgUrl} alt="" />
    </div>
  );
}
