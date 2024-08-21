export function formatDate(inputDate: string) {
  // Cria um objeto Date a partir da string no formato yyyy-MM-dd
  const dateParts = inputDate.split("-");
  const year = dateParts[0];
  const month = dateParts[1];
  const day = dateParts[2];

  // Retorna a data formatada no formato dd/MM/yyyy
  return `${day}/${month}/${year}`;
}
