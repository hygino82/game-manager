export type ConsoleType = {
  id?: string;
  name: string;
  releaseDate: string;
  imageUrl?: string;
  createAt?: string;
  updateAt?: string;
  company: string;
};

export type Game = {
  id?: number;
  name: string;
  releaseDate: string;
  consoleName?: string;
  consoleId?: number;
  imageUrl: string;
  personalCode?: string;
};

export type ConsolePageType = {
  content: ConsoleType[];
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  first: boolean;
  numberOfElements: number;
  empty: boolean;
};

export type GamePageType = {
  content: Game[];
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  first: boolean;
  numberOfElements: number;
  empty: boolean;
};
