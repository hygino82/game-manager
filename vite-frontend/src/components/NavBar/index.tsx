import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav">
          <li className="nav-item active">
            <Link to="/" className="nav-link">Home</Link>
          </li>
          <li className="nav-item active">
            <Link to="/console/insert" className="nav-link">Inserir console</Link>
          </li>
          <li className="nav-item active">
            <Link to="/game/insert" className="nav-link">Inserir jogo</Link>
          </li>
          <li className="nav-item">
            <Link to="/console/list" className="nav-link">Listar consoles</Link>
          </li>
          <li className="nav-item">
            <Link to="/game/list" className="nav-link">Listar jogos</Link>
          </li>
          <li className="nav-item">
            <Link to="/console/card/list" className="nav-link">Cartões de consoles</Link>
          </li>
          <li className="nav-item">
            <Link to="/game/card/list" className="nav-link">Cartões de jogos</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}
