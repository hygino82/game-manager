import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import ConsoleForm from './routes/ConsoleForm/index.tsx';
import ConsoleCardList from './routes/ConsoleCardList/index.tsx';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        element: <ConsoleCardList />,
      },
      {
        path: "console-insert",
        element: <ConsoleForm />,
      },
      {
        path: "console-list",
        element: <ConsoleCardList />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
