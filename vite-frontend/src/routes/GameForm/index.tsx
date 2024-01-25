import axios from "axios";
import { useEffect, useState } from "react";
import { ConsoleType, GameType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import './styles.css';

export default function GameForm() {
  const [nome, setNome] = useState<string>("");
  const [ano, setAno] = useState<number>(2010);
  const [imagem, setImagem] = useState<string>("");
  const [consoleId, setConsoleId] = useState<string>('');
  const [personalCode, setPersonalCode] = useState<string>("");
  const [consoleList, setConsoleList] = useState<ConsoleType[]>([]);

  function getConsoleId(e: any) {
    e.preventDefault();
    setConsoleId(e.target.value);
  }

  function inserir() {
    const jogo: GameType = {
      name: nome,
      releaseYear: ano,
      imageUrl: imagem,
      consoleId: consoleId,
      personalCode: personalCode,
    };

    console.log(jogo);

    axios
      .post(`${BASE_URL}/game`, {
        name: nome,
        releaseYear: ano,
        imageUrl: imagem,
        consoleId: consoleId,
        personalCode: personalCode,
      })
      .then(function (response) {
        // console.log(response);
        alert('Jogo adicionado ' + response.data.name);
        setImagem('');
        setNome('');
        setPersonalCode('');
        setAno(2010);
      })
      .catch(function (error) {
        console.log(error);
      });

  }

  useEffect(() => {
    axios.get(`${BASE_URL}/console`).then((response) => {
      const data = response.data.content as ConsoleType[];
      setConsoleList(data);
    });
  }, []);

  return (
    <div id="insert-form">
      <h3>Inserir jogo</h3>
      <p>Nome</p>
      <input
        type="text"
        name="gameName"
        id="gameName"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
        className="campos"
      />
      <p>Ano</p>
      <input
        type="number"
        name="gameYear"
        id="gameYear"
        value={ano}
        onChange={(f) => setAno(Number(f.target.value))}
      />
      <p>Link da imagem</p>
      <input
        type="text"
        name="gameImg"
        id="gameImg"
        value={imagem}
        onChange={(g) => setImagem(g.target.value)}
      />
      <p>Código pessoal</p>{" "}
      <input
        type="text"
        name="gameCode"
        id="gameCode"
        value={personalCode}
        onChange={(c) => setPersonalCode(c.target.value)}
      />
      <select
        className="form-select form-select-lg mb-3 campos"
        aria-label=".form-select-lg example"
        onChange={(e) => getConsoleId(e)}
        value={consoleId}
      >
        {consoleList.map((x) => {
          return (
            <option value={x.id} key={x.id}>
              {x.name}
            </option>
          );
        })}
      </select>
      <button type="submit" className="btn btn-primary" onClick={inserir}>
        Adicionar
      </button>
    </div>
  );
}
