const isProd= process.env.NODE_ENV === 'production'

const devUrl = 'http://127.0.0.1:8080'

const prodUrl = ''

const config = {
    isProd,
    api: isProd ? prodUrl : devUrl,
}

export default config

