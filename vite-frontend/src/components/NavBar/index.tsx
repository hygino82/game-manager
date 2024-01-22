export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav">
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
            <a className="nav-link" href="card-list">
              Cartões
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="console-form">
              Formulário de Console
            </a>
          </li>
        </ul>
      </div>
    </nav>
  );
}
