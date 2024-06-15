import matplotlib.pyplot as plt

# Dados da tabela
resolucoes = [
    "3036 x 4048",
    "2500 x 3336",
    "1500 x 1992",
    "1000 x 1332",
    "800 x 1066",
    "600 x 800",
    "400 x 533",
    "200 x 266",
    "180 x 120"
]

speed_up = [209, 159, 74, 43, 36, 26, 23, 12, 8]

# Gerar o gráfico
plt.figure(figsize=(10, 6))
plt.plot(resolucoes, speed_up, marker='o', linestyle='-', color='b')

# Adicionar título e rótulos
plt.title('Speed-up em função da Resolução')
plt.xlabel('Resolução')
plt.ylabel('Speed-up')
plt.grid(True)
plt.xticks(rotation=45)
plt.tight_layout()

# Mostrar o gráfico
plt.show()
