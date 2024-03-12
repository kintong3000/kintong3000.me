<template>
  <header class="w-full fixed z-100">

    <nav class="h-16">
      <div class="nav h-16" :class="{ top: isTop }">
        <NuxtLink class="w-12 h-12  m-5 select-none outline-none pt-1 logo" to="/" title="back to home">
          <!--        <router-link class="w-12 h-12 absolute xl:fixed m-5 select-none outline-none" to="/">-->
          <logo/>
        </NuxtLink>

        <div class="spacer"/>
        <div class="right">
          <NuxtLink to="/blog">
            Blog
          </NuxtLink>
          <NuxtLink to="/projects">
            Projects
          </NuxtLink>
          <div class="divider"></div>

          <a href="https://github.com/kintong3000" title="Github">
            <IconsSkillIconsGithubDark class="icon1"/>
            <IconsSkillIconsGithubLight class="icon2"/>
          </a>
          <div class="divider"></div>
<!--          <a href="https://discordapp.com/users/kintong#5614" title="Discord">-->
<!--            <IconsSkillIconsDiscord/>-->
<!--          </a>-->
<!--          <div class="divider"></div>-->
          <a href="https://t.me/kintong3000" title="Discord">
            <IconsLogosTelegram/>
          </a>
          <div class="divider"></div>

          <ToggleDarkSwitch/>
        </div>
      </div>
    </nav>


  </header>
  <div class="h-16"></div>
</template>

<script lang="ts" setup>

const isTop = ref(true)
const isDark = useDark()
const handleScroll = () => {
  // 判断滚动条位置
  isTop.value = window.scrollY === 0
}

onMounted(() => {
  // 添加滚动监听事件
  window.addEventListener('scroll', handleScroll)
})

onBeforeUnmount(() => {
  // 移除滚动监听事件
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.nav .logo{
  opacity: 1;
}
.divider {
  margin-right: 8px;
  margin-left: 8px;
  width: 1px;
  height: 24px;
  background-color: var(--vp-c-divider);
  content: "";
}

.nav {
  //padding: 1rem;
  padding: 0 32px;
  width: 100%;
  display: grid;
  grid-template-columns: max-content auto max-content;
  box-sizing: border-box;
  border-bottom: 1px solid transparent;
}

.nav > * {
  margin: auto;
}

.nav img {
  margin-bottom: 0;
}

.nav a {
  cursor: pointer;
  text-decoration: none;
  color: inherit;
  transition: opacity 0.2s ease;
  opacity: 0.6;
  outline: none;
}

.nav a:hover {
  opacity: 1;
  text-decoration-color: inherit;
}

.nav .right {
  display: grid;
  grid-gap: 1.2rem;
  grid-auto-flow: column;
}

.nav .right > * {
  margin: auto;
}

@media (min-width: 960px) {
  .nav {
    background-color: transparent;
  }

  .nav:not(.top) {
    background-color: var(--c-bg);
    border-bottom-color: var(--vp-c-divider);
    //background-color: #2b2b2f;
    //border-bottom-color: #545454;
  }
}

html:not(.dark) .icon2 {
  display: none;
}

.dark .icon1 {
  display: none;
}

</style>
