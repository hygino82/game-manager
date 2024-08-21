import semImagem from "../../sem-imagem.svg";
import { ConsoleType } from "../../types/custom-types";
import "./styles.css";

type Props = {
  obj: ConsoleType;
};

export function ConsoleCard({ obj }: Props) {
  return (
    <div className="card" id="console-card" key={obj.id}>
      <img
        className="card-img-top"
        src={obj.imageUrl}
        alt=""
        onError={(e) => (e.currentTarget.src = semImagem)}
      />
      <div className="card-body">
        <p className="card-title">{obj.name}</p>
        <p className="card-text">{obj.company}</p>
        <p className="card-text">{obj.releaseDate}</p>
      </div>
    </div>
  );
}
