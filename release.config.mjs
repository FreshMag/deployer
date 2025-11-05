import config from 'semantic-release-preconfigured-conventional-commits' with { type: 'json' };

export default {
    ...config,
    plugins: [
        ...config.plugins.filter(p => !(Array.isArray(p) && p[0] === '@semantic-release/exec')),

        ['@semantic-release/exec', {
            prepareCmd: './gradlew --no-daemon clean build || exit 4',
        }],

        ['@semantic-release/github', {
            assets: ['build/libs/*.jar'],
        }],

        '@semantic-release/git',
    ],
};
