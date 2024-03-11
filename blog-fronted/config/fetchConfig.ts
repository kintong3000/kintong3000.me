const isProd:boolean = process.env.NODE_ENV === 'production'

const devUrl:string = 'http://127.0.0.1:8080'

const runtimeconfig = useRuntimeConfig()

console.log(runtimeconfig.public.API_URL);
// @ts-ignore
const prodUrl:string = runtimeconfig.public.API_URL;

const config:{isProd:boolean,api:string} = {
    isProd,
    api: isProd ? prodUrl : devUrl,
}

export default config
