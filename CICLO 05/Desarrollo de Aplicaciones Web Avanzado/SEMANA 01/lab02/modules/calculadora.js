function promedio(notas) {
    const suma = notas.reduce((acc, n) => acc + n, 0);
    return suma / notas.length;
}

module.exports = {
    promedio
};