const path = require("path");
const HtmlWebPackPlugin = require("html-webpack-plugin");

module.exports = {
  entry: "./src/index.js",
  output: {
    path: path.resolve(__dirname, "dist"),
  },
  resolve: {
      extensions: [".ts", ".js", ".jsx", ".tsx"],
  },
  devServer: {
    hot: true,
    open: true,
    server: 'http',
    proxy: {
    '/api': {
        target: 'http://localhost:9000',
        changeOrigin: true,
        secure:false,
        pathRewrite: {'^/api': '/api'},
        logLevel: 'debug'
    }
      },

    historyApiFallback: true,
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env", "@babel/preset-react"],
          },
        },
      },
      {
        test: /\.(sass|less|css|scss)$/,
        //include: path.resolve(__dirname, "src"),
        use: ["style-loader", "css-loader"],
      },

      {
        test: /\.(jpe?g|png|gif|svg)$/i,
        loader:'file-loader'
      },
    ],
  },
  plugins: [
    new HtmlWebPackPlugin({
      template: "./src/index.html",
    }),
  ],
};