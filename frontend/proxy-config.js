module.exports = [
    {
      context: [ '/authenticate/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/upload/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

  ]