function areaCuadrado(lado) {
    return lado * lado;
}

function areaTriangulo(base, altura) {
    return (base * altura) / 2;
}

function areaCirculo(radio) {
    return Math.PI * radio * radio;
}

module.exports = {
    areaCuadrado,
    areaTriangulo,
    areaCirculo
}