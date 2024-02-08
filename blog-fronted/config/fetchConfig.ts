const isProd:boolean = process.env.NODE_ENV === 'production'

const devUrl:string = 'https://dev.usemock.com/65bdf10d6309cc7a3772327b'

const prodUrl:string = 'https://dev.usemock.com/65bdf10d6309cc7a3772327b'

const config:{isProd:boolean,api:string} = {
    isProd,
    api: isProd ? prodUrl : devUrl,
}

export default config
