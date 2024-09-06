const fs = require('fs');

function faturamentoDistribuidora() {
    const path = '/home/vitor/Target-System/src/faturamentoMensal.json';

    let jsonString;
    try {
        jsonString = fs.readFileSync(path, 'utf-8');
    } catch (error) {
        console.error('Erro ao ler o arquivo:', error);
        return;
    }

    let incomeArray;
    try {
        const jsonData = JSON.parse(jsonString);
        incomeArray = jsonData.faturamento;
    } catch (error) {
        console.error('Erro ao parsear o JSON:', error);
        return;
    }

    let totalIncome = 0;
    const values = [];

    for (let i = 0; i < incomeArray.length; i++) {
        const item = incomeArray[i];
        const value = parseFloat(item.valor);
        totalIncome += value;
        values[i] = value;
    }

    for (let i = 0; i < incomeArray.length; i++) {
        const item = incomeArray[i];
        const state = item.estado;
        const value = values[i];
        const percentage = (value / totalIncome) * 100;

        console.log(`State: ${state}, Value: ${value.toFixed(2)}, Percentage: ${percentage.toFixed(2)}%`);
    }

    console.log(`Total Income: ${totalIncome.toFixed(2)}`);
}

faturamentoDistribuidora();
