#!/bin/bash

echo "Probando el sistema de Café..."

# 1. Crear un cliente
echo "Creando cliente..."
CLIENTE_ID=$(curl -s -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan Pérez","email":"juan@email.com"}' | jq -r '.id')
echo "Cliente creado con ID: $CLIENTE_ID"

# 2. Crear un café
echo "Creando café..."
CAFE_ID=$(curl -s -X POST http://localhost:8080/coffee \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Espresso","precio":2.50,"origen":"Colombia"}' | jq -r '.id')
echo "Café creado con ID: $CAFE_ID"

# 3. Crear un pedido
echo "Creando pedido..."
PEDIDO_ID=$(curl -s -X POST http://localhost:8080/api/pedidos \
  -H "Content-Type: application/json" \
  -d "{\"cliente\":{\"id\":$CLIENTE_ID},\"cafe\":{\"id\":$CAFE_ID},\"cantidad\":2}" | jq -r '.id')
echo "Pedido creado con ID: $PEDIDO_ID"

# 4. Verificar datos
echo "Verificando datos..."

echo "Lista de clientes:"
curl -s http://localhost:8080/api/clientes | jq

echo "Lista de cafés:"
curl -s http://localhost:8080/coffee | jq

echo "Lista de pedidos:"
curl -s http://localhost:8080/api/pedidos | jq

echo "Pedidos del cliente $CLIENTE_ID:"
curl -s http://localhost:8080/api/pedidos/cliente/$CLIENTE_ID | jq 