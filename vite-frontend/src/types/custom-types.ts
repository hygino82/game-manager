export type ConsoleType = {
  id?: string;
  name: string;
  releaseYear?: number;
  imgUrl?: string;
  createdAt?: string;
  updatedAt?: string;
};

export type GameType = {
  id?: string;
  name: string;
  releaseYear: number;
  consoleName?: string|undefined;
  consoleId?: string;
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
  content: GameType[];
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  first: boolean;
  numberOfElements: number;
  empty: boolean;
};
