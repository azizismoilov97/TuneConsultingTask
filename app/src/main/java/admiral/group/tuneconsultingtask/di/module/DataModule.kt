package admiral.group.tuneconsultingtask.di.module


import admiral.group.tuneconsultingtask.data.local.ProjectDAO
import admiral.group.tuneconsultingtask.data.local.ProjectDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): ProjectDatabase {
        return Room.databaseBuilder(
            context, ProjectDatabase::class.java,
            ProjectDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: ProjectDatabase): ProjectDAO {
        return blogDatabase.projectDAO()
    }
}