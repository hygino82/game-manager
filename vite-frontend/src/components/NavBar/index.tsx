export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav">
          <li className="nav-item active">
            <a className="nav-link" href="/">
              Home
            </a>
          </li>
          <li className="nav-item active">
            <a className="nav-link" href="console-insert">
              Inserir console
            </a>
          </li>
          <li className="nav-item active">
            <a className="nav-link" href="game-insert">
              Inserir jogo
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="console-list">
              Listar consoles
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="game-list">
              Listar jogos
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="console-card-list">
              Cartões de consoles
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="game-card-list">
              Cartões de jogos
            </a>
          </li>
        </ul>
      </div>
    </nav>
  );
}
