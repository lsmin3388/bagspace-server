#!/bin/bash

if [ -z "$1" ]; then
  echo "Usage: $0 <password>"
  exit 1
fi

PASSWORD="$1"

# htpasswd로 bcrypt 해시 생성
RAW_HASH=$(htpasswd -bnBC 10 "" "$PASSWORD" | cut -d ":" -f2- | tr -d '\n')

# $2y$ → $2a$ 치환
HASH=$(echo "$RAW_HASH" | sed 's/^\$2y\$/\$2a\$/')

# 결과 출력
echo ""
echo "✅ BCrypt 해시 생성 완료:"
echo "export CONFIG_USER=admin"
echo "export CONFIG_PASS='$HASH'"
