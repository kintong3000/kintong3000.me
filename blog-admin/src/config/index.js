const isProd= process.env.NODE_ENV === 'production'

const devUrl = 'http://127.0.0.1:8080'

const prodUrl = 'http://38.46.31.148:8080'

const config = {
    isProd,
    api: isProd ? prodUrl : devUrl,
}

export default config

