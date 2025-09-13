const isProd= process.env.NODE_ENV === 'production'

// const devUrl:string = 'https://dev.usemock.com/65bdf10d6309cc7a3772327b'
const devUrl = 'http://127.0.0.1:8080'

const prodUrl = 'https://dev.usemock.com/65bdf10d6309cc7a3772327b'

const config = {
    isProd,
    api: isProd ? prodUrl : devUrl,
}

export default config
