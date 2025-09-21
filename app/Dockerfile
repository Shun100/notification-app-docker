# ベースイメージ (Java 21)
FROM eclipse-temurin:21-jdk as builder

# 作業用ディレクトを作成
WORKDIR /app

# Gradle wrapperを使用するために一式コピー
COPY . .

# Gradle wrapperに実行権限を与える
RUN chmod +x ./gradlew

# ポートを明示
EXPOSE 8080

# ビルド＋デプロイ
CMD ["./gradlew", "bootRun"]
